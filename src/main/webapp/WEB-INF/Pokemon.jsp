<%--
  Created by IntelliJ IDEA.
  User: Théo
  Date: 20/11/2020
  Time: 10:32
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
                <li class="is-active"><a href="#" aria-current="page">Pokemons</a></li>
            </ul>
        </nav>
        <h1 class="title">Pokemons</h1>
        <div class="columns">
            <div class="column is-grouped-centered">
                <form action="PokemonServlet" method="post">
                    <div class="field">
                        <label class="label">ID</label>
                        <div class="control">
                            <input name="id" class="input" type="text" placeholder="id" value="${currentPokemon.id}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Nom</label>
                        <div class="control">
                            <input name="nom" class="input" type="text" placeholder="nom" value="${currentPokemon.name}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Poids</label>
                        <div class="control">
                            <input name="type" class="input" type="text" placeholder="poids" value="${currentPokemon.weight}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Taille</label>
                        <div class="control">
                            <input name="type" class="input" type="text" placeholder="taille" value="${currentPokemon.height}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Dresseurs</label>
                        <div class="control">
                            <div class="select">
                                <select name="dresseurs">
                                    <c:forEach var="trainer" items="${trainers}">
                                        <c:if test="${trainer.id.equals(currentPokemon.trainer.id)}">
                                            <option value="${trainer.name}" selected>${trainer.name} ${trainer.firstname}</option>
                                        </c:if>
                                        <c:if test="${!trainer.id.equals(currentPokemon.trainer.id)}">
                                            <option value="${trainer.name}">${trainer.name} ${trainer.firstname}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-link is-light" name="precedent">Précédent</button>
                        </div>
                        <div class="control">
                            <button class="button is-success is-light" name="nouveau">Nouveau</button>
                        </div>
                        <div class="control">
                            <button class="button is-warning is-light" name="modifier">Modifier</button>
                        </div>
                        <div class="control">
                            <button class="button is-danger is-light" name="supprimer">Supprimer</button>
                        </div>
                        <div class="control">
                            <button class="button is-link is-light" name="suivant">Suivant</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

