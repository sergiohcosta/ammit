<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${redirTo == 'CasoTesteGerenciar'}">
<c:redirect url="/Controle?logica=Casoteste.Gerenciar&status=${status}&msg=${msg}&qId=${q.id}"/>
</c:if>

<c:if test="${redirTo == 'QuestaoGerenciar'}">
<c:redirect url="/Controle?logica=Questao.Gerenciar&status=${status}&msg=${msg}"/>
</c:if>

<c:if test="${redirTo == 'AcessoLogin'}">
<c:redirect url="/Controle?logica=Acesso.Login&msg=success"/>
</c:if>

<c:if test="${redirTo == 'UsuarioGerenciar'}">
<c:redirect url="/Controle?logica=Usuario.Gerenciar&status=${status}&msg=${msg}"/>
</c:if>

<c:if test="${redirTo == 'Corrigir'}">
<c:redirect url="/Controle?logica=Resposta.Corrigir&rId=${rId}"/>
</c:if>

