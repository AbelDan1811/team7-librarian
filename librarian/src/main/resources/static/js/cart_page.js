/**
 * 
 */

$(document).ready(function(){
	
	$.get("https://localhost:8443/api/carts", function(json, status){
		var data = json;
		data.sort(sortByCreatedTime);
		showData(data);
		$(document).ready(function(){
		  $("#filter").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	});
	
});
function sortByCreatedTime(cartA, cartB){
	var createdA = cartA['created'];
	var createdB = cartB['created'];
	if (createdA < createdB)
		return 1;
	else if (createdA > createdB)
		return -1;
	return 0;
}

function showData(data){
	var showedData = [];
	for (var i=0;i<data.length;i++){
		var id ='<td class = "id"><a href = "https://localhost:8443/resolve/'+data[i]['id']+'">'+ (i+1) +'</a></td>'; 
		var email ='<td class = "email">'+ data[i]['owner']['email']+'</td>';
		var fullName = '<td class=  "fullname">'+ data[i]['owner']['fullName'] +'</td>';
		var items = [];
		for (var j =0;j<data[i]['items'].length;j++){
			items.push(data[i]['items'][j]['title']);
		}
		var createdDate = data[i]['created'].substring(0,10).split('-');
		
		var returned = data[i]['returned'] ? "Resolved" : "Unresolved";
		
		var books = '<td class = "books">'+ items.join(", ") +'</td>';
		var created = '<td class = "created">'+ createdDate[2]+"-"+ createdDate[1]+"-"+createdDate[0]+'</td>';
		
		var status = '<td class = "status">'+ returned +'</td>';
		showedData.push('<tr>');
		showedData.push(id);
		showedData.push(email);
		showedData.push(fullName);
		showedData.push(books);
		showedData.push(created);
		showedData.push(status);
		showedData.push('</tr>');
	}
	$('tbody').html(showedData.join(''));
}