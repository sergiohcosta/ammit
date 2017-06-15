<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${redirTo == 'CasoTesteGerenciar'}">
<c:redirect url="/Controle?logica=Casoteste.Gerenciar&qId=${q.id}"/>
</c:if>

<c:if test="${redirTo == 'QuestaoGerenciar'}">
<c:redirect url="/Controle?logica=Questao.Gerenciar"/>
</c:if>

<c:if test="${redirTo == 'AcessoLogin'}">
<c:redirect url="/Controle?logica=Acesso.Login&msg=success"/>
</c:if>