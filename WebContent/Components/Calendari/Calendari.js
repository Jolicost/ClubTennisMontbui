var evnts = LoadEvents();
var pistes = LoadPistes();
var mapa = SplitEvents(evnts,pistes);

$('.VeurePista').click(function(){
	AlternarPista($(this).attr("idpista"),mapa);
	rerenderEvents(evnts,mapa,mapaTipus);
	$(this).find('h3').toggleClass('text-info');
});

$('.VeureTipus').click(function(){
	AlternarTipus($(this).attr("nomTipus"),mapaTipus);
	rerenderEvents(evnts,mapa,mapaTipus);
	$(this).find('h3').toggleClass('text-info');
});