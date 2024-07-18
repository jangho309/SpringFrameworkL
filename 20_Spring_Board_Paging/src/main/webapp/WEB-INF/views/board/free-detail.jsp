<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 24. 7. 15.
  Time: 오전 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>

</head>
<body>
    <div>
        <jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>

        <main>
            <div class="container w-50 mt-5 mb-5">
                <h4>자유게시글 상세</h4>
            </div>
            <div class="container mt-3 w-50">
                <form id="modify-form" action="/board/modify.do" method="post">
                    <input type="hidden" name="id" value="${freeBoard.id}">
                    <input type="hidden" name="type" value="free">
                    <div class="form-group">
                        <label for="title">제목</label>
                        <input type="text" class="form-control" id="title" name="title" value="${freeBoard.title}" required>
                    </div>
                    <div class="form-group mt-3">
                        <label for="nickname">작성자</label>
                        <input type="text" class="form-control" id="nickname" name="nickname" value="${freeBoard.nickname}" readonly>
                    </div>
                    <div class="form-group mt-3">
                        <label for="content">내용</label>
                        <textarea class="form-control" id="content" name="content" rows="10" required>${freeBoard.content}</textarea>
                    </div>
                    <div class="form-group mt-3">
                        <label for="regdate">등록일</label>

                        <input type="text" class="form-control" id="regdate"
                               value='<javatime:format value="${freeBoard.regdate}" pattern="yyyy-MM-dd"/>' readonly required>
                    </div>
                    <div class="form-group mt-3">
                        <label for="moddate">수정일</label>
                        <input type="text" class="form-control" id="moddate"
                               value='<javatime:format value="${freeBoard.moddate}" pattern="yyyy-MM-dd"/>' readonly required>
                    </div>
                    <div class="form-group mt-3">
                        <label for="cnt">조회수</label>
                        <input type="text" class="form-control" id="cnt" name="cnt" value="${freeBoard.cnt}" readonly required>
                    </div>
                    <div class="form-group mt-3">
                        <label for="uploadFiles">파일첨부</label>
                        <input class="form-control" type="file" name="uploadFiles" id="uploadFiles" multiple>
                        <div id="image-preview">
                            <input type="file" id="changeFiles" name="changeFiles" style="display: none;"
                                   multiple>
                            <p style="color: red; font-size:0.9rem;">
                                파일을 변경하려면 이미지를 클릭하세요. 파일을 다운로드하려면 파일이름을 클릭하세요. 파일을 추가하려면 파일 선택 버튼을 클릭하세요.
                            </p>
                            <div id="preview" class="mt-3 text-center"
                                 data-placeholder="파일을 첨부하려면 파일선택 버튼을 누르세요.">
                            </div>
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${loginMember ne null and loginMember.id eq freeBoard.WRITER_ID}">
                            <div class="container mt-3 mb-5 w-50 text-center">
                                <button type="submit" id="btn-update" class="btn btn-outline-secondary">수정</button>
                                <button type="button" id="btn-delete" class="btn btn-outline-secondary ml-2" onclick="location.href='/board/delete.do?id=${freeBoard.id}&type=free'">삭제</button>
                            </div>
                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>
                </form>
            </div>
        </main>

        <jsp:include page="${pageContext.request.contextPath}/footer.jsp"></jsp:include>
    </div>
    <script>
        $(() => {
            $("#modify-form").on("submit", (e) => {
               $("#regdate").val(`\${\$("#regdate").val()}T00:00:00`);
               $("#moddate").val(`\${\$("#moddate").val()}T00:00:00`);
            });
        })
    </script>
</body>
</html>
