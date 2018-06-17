$(document).ready(function(){
		$("#addBook").submit(function(e){
			e.preventDefault();
			var data = $("#addBook").serialize();
			$.post("https://localhost:8443/api/books", data, function(data, status){
				if (status === "success"){
					$("#notification").text("Successfully Added!");
				}
				else {
					$("#notification").text("Failed!");
				}
				$("#notification").show(function(){
					$("#notification").fadeOut(3000); 
				})
				$("input[type='text']").val('');
			});
		});
	});