package Controle.Casoteste;

import Compilador.CodigoCompilado;
import Compilador.Compilador;
import beans.Questao;
import beans.Casoteste;
import Controle.Logica;
import DAO.CasotesteDAO;
import DAO.QuestaoDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/* PARAMETROS OBRIGATORIOS:
qId: para saber de qual questão estamos tratando
 */

 /* PARAMETROS OPCIONAIS:
op: para saber no POST se é cadastro ou alteracao
id: se for > 0, editar
 */
public class Cadastrar implements Logica {

    private final String TMP = "C:\\tmp\\";

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        System.out.println("Executando a logica " + this.getClass().getName() + " ...");

        QuestaoDAO qDao = new QuestaoDAO();
        Questao q = new Questao();

        CasotesteDAO ctDao = new CasotesteDAO();
        Casoteste cteste;

        int questaoId = 0;
        int casostesteId = 0;

        try {
            questaoId = Integer.parseInt(req.getParameter("qId"));
            q = qDao.obtemQuestao(questaoId);

            if (q.getId() < 1) {
                throw new NumberFormatException();
            }

            req.setAttribute("q", q);

        } catch (NumberFormatException e) {
            req.setAttribute("status", 0);
            req.setAttribute("msg", "Selecione uma questão para gerenciar seus Casos de Teste");
            req.setAttribute("redirTo", "QuestaoGerenciar");
            return "/redirect.jsp";
        }

        // So tenta processar informacoes se for um POST
        if (req.getMethod().equals("POST")) {

            try {
                casostesteId = Integer.parseInt(req.getParameter("id"));

            } catch (NumberFormatException e) {
                req.setAttribute("status", 0);
                req.setAttribute("msg", "Selecione um Caso de Teste para gerenciar");
                req.setAttribute("redirTo", "CasoTesteGerenciar");
                return "/redirect.jsp";
            }

            // seta a mensagem como cadastrado como sucesso     
            req.setAttribute("status", "1");
            ArrayList<String> msgErro = new ArrayList<>();

            // verificacao server-side do POST
            // TODO: implementar validacao nos campos que faltam e checar se há melhorias possíveis nas validações
            String titulo = req.getParameter("titulo");

            if (titulo.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errTitulo", "1");
                msgErro.add("O campo Título deve conter pelo menos 3 caracteres");
            }

            String conteudo = req.getParameter("conteudo");

            if (conteudo.length() < 3) {
                req.setAttribute("status", "0");
                req.setAttribute("errConteudo", "1");
                msgErro.add("O campo <b>Conteudo</b> deve conter pelo menos 3 caracteres");
            }

            String tipo_entradas = req.getParameter("tipo_entradas");
            String ammit_seed = req.getParameter("ammit_seed");
            int ammit_qtde = Integer.parseInt((req.getParameter("ammit_qtde")));
            String entrada = req.getParameter("entrada");

            if ("entradaammit".equals(tipo_entradas)) {
                entrada = "";
                if (ammit_seed.length() < 1) {
                    req.setAttribute("status", "0");
                    req.setAttribute("errAmmit_seed", "1");
                    msgErro.add("O campo <b>Sintaxe Ammit</b> deve conter pelo menos 1 caracter");
                }

                if (ammit_qtde < 0) {
                    req.setAttribute("status", "0");
                    req.setAttribute("errAmmit_qtde", "1");
                    msgErro.add("A quantidade de linhas gerada pelo Ammit deve ser pelo menos 1");
                }
            } else {
                ammit_seed = "";
                ammit_qtde = 0;
                if (entrada.length() < 1) {
                    req.setAttribute("status", "0");
                    req.setAttribute("errEntrada", "1");
                    msgErro.add("O campo <b>Entrada</b> deve conter pelo menos 1 caracter");
                }

            }

            String tipo_saidas = req.getParameter("tipo_saidas");
            String saida = req.getParameter("saida");
            String codigofonte_linguagem = req.getParameter("codigofonte_linguagem");
            InputStream inputStream = null;
            boolean doFileUpload = true;

            // eu quero trabalhar com arquivo upado, entao...
            if ("saidacodigo".equals(tipo_saidas)) {
                Part filePart = req.getPart("codigofonte");
                if (filePart != null) {
                    // Mostro alguns debugs...
                    System.out.println("getName=" + filePart.getName());
                    System.out.println("getSize=" + filePart.getSize());
                    System.out.println("getContentType=" + filePart.getContentType());

                    // Se o tamanho do arquivo for vazio...
                    if (filePart.getSize() <= 0) {
                        // Se for um CADASTRO, É UM ERRO
                        if (casostesteId == 0) {
                            inputStream = null;
                            req.setAttribute("status", "0");
                            req.setAttribute("errCodigofonte", "1");
                            msgErro.add("O <b>Código fonte</b> deve ser um arquivo de texto plano");
                        } // Se for um UPDATE, CONFIGURE PRA NAO MEXER NO CAMPO LA NA FRENTE
                        else {
                            doFileUpload = false;
                        }
                    } // se o tamanho do arquivo NAO for vazio...
                    else {
                        saida = "";
                        // CADASTRE ou SOBREPONHA (whatever) o arquivo upado
                        inputStream = filePart.getInputStream();
                        InputStream validaStream =  filePart.getInputStream();
                        
                        
                        String relativeWebPath = "/WEB-INF/tmp/";
                        String absoluteDiskPath = req.getServletContext().getRealPath(relativeWebPath) + File.separator;
                        System.out.println("absoluteDiskPath=" + absoluteDiskPath);
                        
                        
                        // consegui salvar o arquivo, entao...
                        //if (salvaArquivo(TMP + "professor.c", validaStream)) {
                        if (salvaArquivo(absoluteDiskPath + "professor.c", validaStream)) {
                            // vou tentar compilar
                            //CodigoCompilado c = Compilador.compilar(TMP + "professor.c");
                            CodigoCompilado c = Compilador.compilar(absoluteDiskPath + "professor.c");
                            // se nao conseguir compilar...
                            if (!c.isSucesso()) {
                                req.setAttribute("status", "0");
                                req.setAttribute("errCodigofonte", "1");
                                msgErro.add("O <b>Código fonte</b> não compilou! Erros encontrados:<BR>" + c.getErros());
                            }
                        // nao consegui salvar o arquivo, entao...
                        } else {
                            req.setAttribute("status", "0");
                            req.setAttribute("errCodigofonte", "1");
                            msgErro.add("O <b>Código fonte</b> não pode ser salvo!");
                        }
                    }
                }

            } // eu NAO quero trabalhar com arquivo upado, entao...
            else {
                // eu sou obrigado a ter uma SAIDA MANUAL digitada
                if (saida.length() < 1) {
                    req.setAttribute("status", "0");
                    req.setAttribute("errSaida", "1");
                    msgErro.add("O campo <b>Saída</b> deve conter pelo menos 1 caracter");
                }
            }

            req.setAttribute("msgErro", msgErro);
            System.out.println("Erros encontrados: " + msgErro.size());

            if (req.getAttribute("status").equals("1")) {

                cteste = new Casoteste();

                cteste.setId(casostesteId);
                cteste.setQuestao(questaoId);
                cteste.setTitulo(titulo);
                cteste.setConteudo(conteudo);
                cteste.setAmmit_seed(ammit_seed);
                cteste.setAmmit_qtde(ammit_qtde);
                cteste.setEntrada(entrada);
                cteste.setSaida(saida);
                cteste.setCodigofonte(inputStream);
                cteste.setCodigofonte_linguagem(codigofonte_linguagem);

                req.setAttribute("q", q);
                req.setAttribute("status", "1");

                if (casostesteId == 0) {
                    System.out.println("Cadastrando: " + cteste);
                    int lastId = ctDao.insereCasoteste(cteste);
                    //q.setId(lastId);

                    req.setAttribute("msg", "Caso de teste cadastrado com sucesso");

                } else {

                    System.out.println("Editando: " + cteste);

                    if (doFileUpload) {
                        ctDao.alteraCasoteste(cteste);
                    } else {
                        ctDao.alteraCasotesteSemUpload(cteste);
                    }

                    req.setAttribute("msg", "Caso de teste alterado com sucesso");
                }

                req.setAttribute("redirTo", "CasoTesteGerenciar");
                return "/redirect.jsp";

            }
        } else {

            String op = (String) req.getParameter("op");
            if ("editar".equals(op)) {

                try {
                    casostesteId = Integer.parseInt(req.getParameter("id"));
                    cteste = ctDao.obtemCasoteste(Integer.valueOf(req.getParameter("id")));

                    boolean sourceUpado;
                    if (cteste.getCodigofonte() == null) {
                        sourceUpado = false;
                    } else {
                        sourceUpado = true;
                    }

                    req.setAttribute("p", cteste);
                    req.setAttribute("sourceUpado", sourceUpado);

                } catch (NumberFormatException e) {
                    req.setAttribute("status", 0);
                    req.setAttribute("msg", "Selecione um Caso de Teste para gerenciar");
                    req.setAttribute("redirTo", "CasoTesteGerenciar");
                    return "/redirect.jsp";
                }

            }

        }

        return "/pages/casoteste/cadastrar.jsp";

    }

    private boolean salvaArquivo(String path, InputStream src) {
        System.out.println("salvaArquivo path" + path);
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1];
            while (src.read(buffer) > 0) {
                fos.write(buffer);
            }
            fos.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
