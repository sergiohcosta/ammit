<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

redir para ${q.id}

<c:redirect url="/Controle?logica=Casoteste.Gerenciar&q=${q.id}"/>