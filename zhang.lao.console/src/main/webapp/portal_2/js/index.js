$(function(){
	$(".openable").click(function(){
		$(this).children(".submenu").is(":hidden")?$(this).children(".submenu").show():$(this).children(".submenu").hide();
	});
});