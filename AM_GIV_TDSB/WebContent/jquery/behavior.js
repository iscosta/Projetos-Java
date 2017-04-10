function link(l) {
		location.href = l;
}

function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }    
}

function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}



function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58)) return true;
    else {
        if (tecla == 8 || tecla == 0) return true;
        else return false;
    }
}
function formatar(mascara, documento) {
    var i = documento.value.length;
    var saida = mascara.substring(0, 1);
    var texto = mascara.substring(i)

    if (texto.substring(0, 1) != saida) {
        documento.value += texto.substring(0, 1);
    }

}
function MascaraMoeda(campo) { //Cada vez que a tecla é pressionada...
    //Impedimos entrada de letras...
    SomenteNumeroPontoVirgula(campo);
    //Removemos vírgula e ponto da mácara, se tiver...
    var valor = limpar(campo.value, "0123456789");
    //Obtemos o tamanho somente dos números...
    var tamanho = valor.length;

    if (tamanho == 3) {
        mascaraCampo(campo, 'R$#,##');
    }

    if (tamanho == 4) {
        mascaraCampo(campo, 'R$##,##');
    }

    if (tamanho == 5) {
        mascaraCampo(campo, 'R$###,##');
    }

    if (tamanho == 6) {
        mascaraCampo(campo, 'R$#.###,##');
    }

    if (tamanho == 7) {
        mascaraCampo(campo, 'R$##.###,##');
    }

    if (tamanho == 8) {
        mascaraCampo(campo, 'R$###.###,##');
    }

}

//Entrada de números e caracteres específicos apenas
function SomenteNumeroPontoVirgula(campo) {
    var digits = "0123456789,.R$"
    var campo_temp
    for (var i = 0; i < campo.value.length; i++) {
        campo_temp = campo.value.substring(i, i + 1)
        if (digits.indexOf(campo_temp) == -1) {
            campo.value = campo.value.substring(0, i);
            break;
        }
    }
}

// Limpa um string
function limpar(valor, conjuntoVerdade) {
    var resultado = "";
    for (var a = 0; a < valor.length; a++) {
        if (conjuntoVerdade.indexOf(valor.substring(a, a + 1)) >= 0) {
            resultado += valor.substring(a, a + 1);
        }
    }
    return resultado;
}

// Formatação de mascara
function mascaraCampo(campo, formatoMascara) {
    var valorLimpo = limpar(campo.value, "0123456789");
    var resultado = "";
    var b = 0;
    for (var a = 0; a < formatoMascara.length; a++) {
        if (formatoMascara.substring(a, a + 1) == "#") {
            resultado = resultado + valorLimpo.substring(b, b + 1);
            b++;
            if (b >= valorLimpo.length) {
                break;
            }
        } else {
            resultado = resultado + formatoMascara.substring(a, a + 1);
        }
    }
    campo.value = resultado;
}

(function($) {

var tabs =  $(".tabs li a");

tabs.click(function() {
var content = this.hash.replace('/','');
tabs.removeClass("active");
$(this).addClass("active");
$("#content").find('p').hide();
$(content).fadeIn(200);
});

});



function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}


$(document).ready(
		function(){
			$("#botao").focus(
				function(){
					alert("entrou");
					$("#btnConfirma").css("visibility","visible");
				}		
			
			);			
		}
);