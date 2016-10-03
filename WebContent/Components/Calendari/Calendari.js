var evnts = LoadEvents();
var pistes = LoadPistes();
var mapa = SplitEvents(evnts,pistes);

$('.VeurePista').click(function(){
	AlternarPista($(this).attr("idpista"),mapa);
	$(this).find('h3').toggleClass('text-info');
});