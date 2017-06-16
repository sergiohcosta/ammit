<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.usuario.id < 0}">
    <c:redirect url="Controle?logica=Acesso.Login&errLogin=2" />
</c:if>

<c:if test="${empty sessionScope.usuario}">
    <c:redirect url="Controle?logica=Acesso.Login&errLogin=2" />
</c:if>