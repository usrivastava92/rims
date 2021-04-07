package com.app.startup.config.seeding;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import com.app.logging.BaseLoggers;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperEngine {

    private static Class<JasperEngine> clazz;

    {
        clazz = JasperEngine.class;
    }

    public static void compileReportAndWritePdf(String jrxmlPath, String pdfExportPath, Map<String, Object> parameters)
            throws JRException {
        JasperPrint jasperPrint = compileReport(jrxmlPath, parameters);
        if (jasperPrint != null) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfExportPath);
        }
    }

    public static JasperPrint compileReport(String jrxmlPath, Map<String, Object> parameters) throws JRException {
        try (InputStream stream = clazz.getResourceAsStream(jrxmlPath);) {
            final JasperReport jasperReport = JasperCompileManager.compileReport(stream);
            return JasperFillManager.fillReport(jasperReport, parameters);
        } catch (Exception e) {
            BaseLoggers.flowLogger.error("JasperEngine : Exception in compiling report : {}", e);
        }
        return null;
    }

    public static byte[] compileReportAndGetByteArray(String jrxmlPath, Map<String, Object> parameters)
            throws JRException {
        JasperPrint jasperPrint = compileReport(jrxmlPath, parameters);
        if (jasperPrint != null) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                return outputStream.toByteArray();
            } catch (Exception e) {
                BaseLoggers.flowLogger.error("JasperEngine : Exception in compiling report : {}", e);
            }
        }
        return null;
    }
}