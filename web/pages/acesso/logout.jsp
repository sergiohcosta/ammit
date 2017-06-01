<%-- 
    Document   : logout
    Created on : 16/10/2015, 18:47:00
    Author     : sergio
--%>

<?php 
session_start();
session_destroy();
session_unset();

header("Location: login.php");

?>