/**
 * 
 */


$(document).ready(function(){
	$.get("https://localhost:8443/api/books", function(json, status){
		var list = []
		for(var i=0;i<json.length;i++){
			var title = json[i]['title'];
			var available = json[i]['available'];
			if (available > 0)
				list.push("<li><span class = 'title'>"+title+"</span><span style ='float:right;' class = 'available label label-success'>"+ available+"</span></li>");
		}
		$("#bookList").append(list.join(''));
		
		$("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $(".dropdown-menu li").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		});
		
		var pickup = [];
		$("li").click(function(){
			var title = $(this).find("span.title").text();
			$(this).toggle(pickup.indexOf($(this).find("span.title").text()) >-1);
			pickup.push(title);
			showedPickup = [];
			for (var i=0;i<pickup.length;i++){
				showedPickup.push("<button class = 'btn btn-warning btn-xm'>"+pickup[i]+"</button>&nbsp");
			}
			$("#chosenItems").html(showedPickup.join(""));
			$("#addCart").submit(function(e){
				e.preventDefault();
				var data = {};
				data['email'] = $("input[name='email']").val();
				data['fullName'] = $("input[name='fullname']").val();
				data['contactNumber'] = $("input[name='contactNumber']").val();
				data['organization'] = $("input[name='organization']").val();
				data['pickup'] = pickup;
				var jsonData = JSON.stringify(data);
				$.post({
					url :"https://localhost:8443/api/carts",
					type : "POST",
					contentType: 'application/json',
					dataType : 'json',
					data : jsonData
				});
				$("#notification").text("Successfully Add New Cart");
				$("#notification").show(function(){
					$(this).fadeOut(3000);
				})
				
 			})
 			
		});
		
	});
})