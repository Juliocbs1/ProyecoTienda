package com.fenixcode.papeleriarosita.reportes;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fenixcode.papeleriarosita.modelo.Venta;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class VentasExportExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Venta> lista_venta;

	public VentasExportExcel( List<Venta> lista_venta) {

		this.lista_venta = lista_venta;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Ventas");
	}

	private void escribirCabeceraTabla() {
		Row fila = hoja.createRow(0);

		CellStyle estilo = libro.createCellStyle();

		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);

		Cell celda = fila.createCell(0);
		celda.setCellValue("ID-Venta");
		celda.setCellStyle(estilo);

		celda = fila.createCell(1);
		celda.setCellValue("ID-Cliente");
		celda.setCellStyle(estilo);

		celda = fila.createCell(2);
		celda.setCellValue("Total");
		celda.setCellStyle(estilo);

		celda = fila.createCell(3);
		celda.setCellValue("Cambio");
		celda.setCellStyle(estilo);

		celda = fila.createCell(4);
		celda.setCellValue("Fecha");
		celda.setCellStyle(estilo);
	}

	private void escribirDatosTabla() {
		int numeroFilas = 1;

		CellStyle estilo = libro.createCellStyle();

		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);

		for (Venta venta : lista_venta) {
			Row fila = hoja.createRow(numeroFilas++);

			Cell celda = fila.createCell(0);
			celda.setCellValue(venta.getId_venta());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);

			celda = fila.createCell(1);
			celda.setCellValue(venta.getId_cliente());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);

			celda = fila.createCell(2);
			celda.setCellValue(venta.getTotal());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

			celda = fila.createCell(3);
			celda.setCellValue(venta.getCambio());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

			celda = fila.createCell(4);
			celda.setCellValue(venta.getFecha().toString());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

		}
	}

	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraTabla();
		escribirDatosTabla();

		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);

		libro.close();
		outPutStream.close();
	}

}
