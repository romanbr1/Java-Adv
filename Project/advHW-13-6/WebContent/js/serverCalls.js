
$("button.createMagazine")
		.click(
				function() {

 					var title = $("form.createMagazine input.magazineTitle").val();
					var category = $("form.createMagazine input.magazineCategory").val();
					var price = $("form.createMagazine input.magazinePrice").val();

 						var magazine = {
								title : title,
								category : category,
								price : price
						};
//add validation
						$.post("magazine", magazine,
								function(data) {
									if (data == 'Success') {

										alert('Success');
									}
								});

 				});

 $("button.buy-product").click(function() {
	var magazineId = jQuery(this).attr("magazine-id");


 	$.post("bucket", {'id':magazineId},
			function(data) {
				if (data == 'Success') {
					$("[data-dismiss=modal]").trigger({type: "click"});
					alert('Success');
				}
			});
});