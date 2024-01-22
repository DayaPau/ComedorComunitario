import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia;
    private int mes;
    private int anno;

    // Otros métodos y atributos

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    // Métodos getter, setter y otros

    public void darFechaActual() {
        GregorianCalendar gc = new GregorianCalendar();

        dia = gc.get(Calendar.DAY_OF_MONTH);
        mes = gc.get(Calendar.MONTH) + 1;
        anno = gc.get(Calendar.YEAR);
    }

    public Fecha obtenerFechaActualMas3() {
        GregorianCalendar gc = new GregorianCalendar(anno, mes - 1, dia);  // El mes en Calendar es 0-indexado

        gc.add(Calendar.DAY_OF_MONTH, 3);  // Suma 3 días a la fecha actual

        // Verificar si la fecha resultante es jueves o viernes
        int diaSemana = gc.get(Calendar.DAY_OF_WEEK);

        if (diaSemana == Calendar.THURSDAY) {
            // Si es jueves, la entrega es el próximo lunes (sumamos 3 + 1 días)
            gc.add(Calendar.DAY_OF_MONTH, 4);
        } else if (diaSemana == Calendar.FRIDAY) {
            // Si es viernes, la entrega es el próximo martes (sumamos 3 días)
            gc.add(Calendar.DAY_OF_MONTH, 3);
        }

        // Obtener los componentes de la nueva fecha
        int nuevoDia = gc.get(Calendar.DAY_OF_MONTH);
        int nuevoMes = gc.get(Calendar.MONTH) + 1;
        int nuevoAnno = gc.get(Calendar.YEAR);

        // Retornar la nueva fecha
        return new Fecha(nuevoDia, nuevoMes, nuevoAnno);
    }



    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", anno=" + anno +
                '}';
    }
}
