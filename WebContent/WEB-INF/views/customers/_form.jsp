<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
            <br />
        </c:forEach>

    </div>
</c:if>
<label for="company">会社名</label>
<br />
<textarea name="company" rows="2" cols="20">${customer.company}</textarea>
<br />
<br />

<label for="name">顧客名</label>
<br />
<textarea name="name" rows="1" cols="20">${customer.name}</textarea>
<br />
<br />

<label> <input type="radio" name="gender" value="男性">男性</label>
<label> <input type="radio" name="gender" value="女性">女性</label>
<br />
<br />

<label for="email">メールアドレス</label>
<br />
<textarea name="email" rows="1" cols="20">${customer.email}</textarea>
<br />
<br />

<label for="phone">電話番号</label>
<br />
<textarea name="phone" rows="1" cols="20">${customer.phone}</textarea>
<br />
<br />

<label for="memo">メモ</label>
<br />
<textarea name="memo" rows="10" cols="50">${customer.memo}</textarea>
<br />
<br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>