var magazines = null;

$.get("magazines", function(data) {
	if (data !== '') {
		magazines = data;
	}
}).done(function() {
	
	var cardsContent = "";
	jQuery.each(magazines, function(i, value) {
	
		cardsContent+="<div class='col'>" +
					  "<div class='card'>" +
					  "<div class='card-body'>" +
					  "<h5 class='card-title'>" + value.title + "</h5>"+
					  "<h6 class='card-subtitle mb-2 text-muted'>" + value.price + "</h6>"+
					  "<p class='card-text'>" + value.category + "</p>"+
					  "<a class='productCardElement'  href='magazine?id=" + value.id + "' class='card-link'>link</a>"+
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>"
	});
	
	  $('#productCards').html(cardsContent);
	
}).done(function() {
	$.get("user-role", function(data) {
		if (data !== '') {
			userRole = data;
		}
	}).done(function() {
		if(userRole === 'ADMINISTRATOR'){
			$('a.productCardElement').hide();
		}
	});
});