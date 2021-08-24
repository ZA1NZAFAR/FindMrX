<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UploadFile" enctype="multipart/form-data" method="post" >
            <input type="file" name="fileName" />
            <input type="hidden" name="MAX_FILE_SIZE" value="10485760" /><br/><br/>
            <input type="submit" name="submit" value="Envoyer" />
        </form>
    </body>
</html>
