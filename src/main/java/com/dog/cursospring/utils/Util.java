package com.dog.cursospring.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	
	public static String formataDoubleParaReal(Double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return nf.format(valor);
	}
	
	public static String formataDataHoraMinutoSegundo(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return sdf.format(data);
	}
}
