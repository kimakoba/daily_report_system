<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${customer != null}">
                <h2>id : ${customer.id} の顧客情報　詳細ページ</h2>

                <table id="report_list">
                    <tbody>
                        <tr>
                            <th>会社名</th>
                            <td><c:out value="${customer.company}" /></td>
                        </tr>
                        <tr>
                            <th>顧客名</th>
                            <td><c:out value="${customer.name}" /></td>
                        </tr>
                        <tr>
                            <th>性別</th>
                            <td><c:out value="${customer.gender}" /></td>
                        </tr>
                        <tr>
                             <th>メールアドレス</th>
                             <td><c:out value="${customer.email}" /></td>
                        </tr>
                        <tr>
                             <th>電話番号</th>
                             <td><c:out value="${customer.phone}" /></td>
                        </tr>
                         <tr>
                             <th>メモ</th>
                             <td><c:out value="${customer.memo}" /></td>
                        </tr>
                        <tr>
                            <th>取引一覧</th>
                            <td>
                                <table>
                                    <tr>
                                        <th>更新日</th>
                                        <th>担当者</th>
                                        <th>商談内容</th>
                                        <th></th>
                                    </tr>
                                <c:forEach var="report" items="${reports}">
                                        <tr>
                                            <td><fmt:formatDate value="${report.updated_at}" pattern="yyyy-MM-dd" /></td>
                                            <td><c:out value="${report.employee.name}" /></td>
                                            <td><c:out value="${report.negotiation}" /></td>
                                            <td class="report_action"><a href="<c:url value='/reports/show?id=${report.id}' />">詳細</a></td>
                                        </tr>
                                </c:forEach>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${customer.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${customer.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <p><a href="<c:url value='/customers/edit?id=${customer.id}' />">この顧客情報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/customers/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>