<%--
  Created by IntelliJ IDEA.
  User: Théo
  Date: 19/11/2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="section">
    <div class="container">
        <nav class="breadcrumb" aria-label="breadcrumbs">
            <ul>
                <li><a href="/jpa">Home</a></li>
            </ul>
        </nav>
        <h1 class="title">Liste de pokemon</h1>

        <div>
            <c:forEach items="${pokemons}" var="p">
                <tr>
                    <td>${p.name}</td>
                    <td>${p.height}</td>
                    <td>${p.weight}</td>
                </tr>
            </c:forEach>
        </div>
    </div>
</section>