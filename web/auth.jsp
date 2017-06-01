<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionScope.usuario.id == -1}">
    <c:redirect url="Controle?logica=Acesso.Login&errLogin=2" />
</c:if>