/**
 * 
 */
$(document).ready(function(){
	
	$.get("https://localhost:8443/api/books", function(json, status){
		var data = json;
		data.sort(sortByTitle);
		showData(data);
	});
	$("#sortBy").change(function(){
		var filter = $("#filter").val();
		var filterBy = $("#filterBy").val();
		var sortBy = $("#sortBy").val();
		var order = $("#order").val();
		$.get("https://localhost:8443/api/books", function(json, status){
			var data = filterData(json, filter, filterBy);
			sort(data, sortBy, order);
			showData(data);
		});
	});
	$("#order").change(function(){
		var sortBy = $("#sortBy").val();
		var order = $("#order").val();
		var filter = $("#filter").val();
		var filterBy = $("#filterBy").val();
		$.get("https://localhost:8443/api/books", function(json, status){
			var data = filterData(json, filter, filterBy);
			sort(data, sortBy, order);
			showData(data);
		});
	});
	$("#filter").change(function(){
		var filter = $("#filter").val();
		var filterBy = $("#filterBy").val();
		var sortBy = $("#sortBy").val();
		var order = $("#order").val();
		$.get("https://localhost:8443/api/books", function(json, status){
			var data = filterData(json, filter, filterBy);
			sort(data, sortBy, order);
			showData(data);
		});
	});
	$("#filterBy").change(function(){
		var filter = $("#filter").val();
		var filterBy = $("#filterBy").val();
		var sortBy = $("#sortBy").val();
		var order = $("#order").val();
		$.get("https://localhost:8443/api/books", function(json, status){
			var data = filterData(json, filter, filterBy);
			sort(data, sortBy, order);
			showData(data);
		});
	});
});


function filterData(data, filter ,filterBy){
	if (filter.length === 0 || !filter.trim())
		return data;
	var result = [];
	for (var i=0;i<data.length;i++)
		if (data[i][filterBy].toLowerCase().indexOf(filter.toLowerCase())!== -1){
			result.push(data[i]);
		}
	return result;
}

function sort(data, sortBy, order){
	if (sortBy === "1" && order === "1"){
		data.sort(sortByTitle);
	}
	else if (sortBy === "2" && order === "1"){
		data.sort(sortByNumber);
	}
	else if (sortBy === "1" && order === "2"){
		data.sort(sortByTitle).reverse();
	}
	else if (sortBy === "2" && order === "2"){
		data.sort(sortByNumber).reverse();
	}
	else if (sortBy === "3" && order === "1"){
		data.sort(sortByAvailable);
	}
	else if (sortBy === "3" && order === "2"){
		data.sort(sortByAvailable).reverse();
	}
}

function sortByTitle(bookA, bookB){
	var titleA = bookA['title'].toLowerCase();
	var titleB = bookB['title'].toLowerCase();
	if (titleA < titleB)
		return -1;
	else if (titleA > titleB)
		return 1;
	return 0;
}

function sortByNumber(bookA, bookB){
	var titleA = bookA['number'];
	var titleB = bookB['number'];
	if (titleA < titleB)
		return -1;
	else if (titleA > titleB)
		return 1;
	return sortByTitle(bookA, bookB);
}
function sortByAvailable(bookA, bookB){
	var titleA = bookA['available'];
	var titleB = bookB['available'];
	if (titleA < titleB)
		return -1;
	else if (titleA > titleB)
		return 1;
	return sortByTitle(bookA, bookB);
}

function showData(data){
	var showedData = [];
	for (var i=0;i<data.length;i++){
		var id ='<td class = "id">'+ (i+1) +'</td>'; 
		var title ='<td class = "title">'+'<a href ="https://localhost:8443/librarian/book-detail/'+data[i]['slug']+'">'+ data[i]['title'] +'</a>'+'</td>';
		var author = '<td class=  "author">'+ data[i]['author'] +'</td>';
		var publisher = '<td class = "publisher">'+ data[i]['publisher'] +'</td>';
		var genre = '<td class = "genre">'+ data[i]['genres'][0]['type'] +'</td>';
		var number = '<td class = "number">'+ data[i]['number'] +'</td>';
		var available =  '<td class = "available">'+ data[i]['available'] +'</td>';
		showedData.push('<tr>');
		showedData.push(id);
		showedData.push(title);
		showedData.push(author);
		showedData.push(publisher);
		showedData.push(genre);
		showedData.push(available);
		showedData.push(number);
		showedData.push('</tr>');
	}
	$('tbody').html(showedData.join(''));
}