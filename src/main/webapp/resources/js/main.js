/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */$(document).ready(function() {

        $(".przyciskRezerwacji").mouseover(function() {
		$(this).animate({
			opacity : '0.2'
		}, 100);
		$(this).css("background-color", "#6c361d");
               if(($(this).parent().find(".bSamochod_napis").length===0)) $(this).parent().append("<div class='bSamochod_napis'> REZERWUJE </div>");
                $(this).parent().find(".bSamochod_napis").show();
	});
        $(".przyciskRezerwacji").mouseleave(function() {
		$(this).animate({
			opacity : '1'
		}, 200);
		$(this).css("background-color", "");
                $(this).parent().find(".bSamochod_napis").hide();
	});
});