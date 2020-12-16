<%--
  Created by IntelliJ IDEA.
  User: Théo
  Date: 19/11/2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/index.html" %>
<section class="section">
    <div class="container">
        <nav class="breadcrumb" aria-label="breadcrumbs">
            <ul>
                <li><a href="/jpa">Home</a></li>
                <li class="is-active"><a href="#" aria-current="page">Jeu</a></li>
            </ul>
        </nav>
        <h1 class="title">Jeu</h1>

        <div class="field is-grouped">
            <form action="HomeServlet" method="post">
                <input class="input" name="number" type="number" min="0" max="10">
                <div class="control">
                    <input class="button is-success" value="send" type="submit">
                </div>
            </form>
        </div>
    </div>
</section>
