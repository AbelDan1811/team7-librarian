/**
 * 
 */

$(document).ready(function(){
	$.get("https://localhost:8443/api/books/"+$("#slug").text(), function(data, status){
		var title = data['title'];
		var author = data['author'];
		var publisher = data['publisher'];
		var genre = data['genres'][0]['type'];
		var number = data['number'];
		var available = data['available'];
		$("#title").html("<b>"+title+"</b>");
		$("#author").html(":&nbsp&nbsp   "+author);
		$("#publisher").html(":&nbsp&nbsp   "+publisher);
		$("#genre").html(":&nbsp&nbsp   "+genre);
		$("#available").html(":&nbsp&nbsp   "+available );
		$("#number").html(":&nbsp&nbsp   "+number);
		
		
	});
})