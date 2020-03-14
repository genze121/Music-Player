<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
.buttonList{
margin-up: 60%;

}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="buttonList"><form action="playPreviousSongController" method="post"><input type="submit" value="Previous" style="background-color: blue;font-size: 200%;" ></form></div>
<div class="buttonList"><form action="playSongController" method="post"><input type="submit" value="Play"></form></div>
<div class="buttonList"><form action="pauseSongController" method="post"> <input type="submit" value="Pause"></form></div>
<div class="buttonList"><form action="playNextSongController" method="post"><input type="submit" value="Next"></form></div>

</body>
</html>