/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodeacopio;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenia
 */
public class CentroDeAcopio {

    /**
     * @param args the command line arguments
     */
    int contadorEntrega = 0;
    int contadorRecoje = 0;
    public static Interfaz interfaz = new Interfaz();

    public static void main(String[] args) {
        // TODO code application logic here
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        ColaBloqueo<Integer> cola = new ColaBloqueo<>(20);
        interfaz.setVisible(true);

        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(50);
                Hilo hilo = new Hilo(cola, i);
                ejecutor.execute(hilo);

            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static class Hilo implements Runnable {

        ColaBloqueo<Integer> cola;
        int numero;
        boolean insertar;

        public Hilo(ColaBloqueo<Integer> cola, int numero) {
            this.cola = cola;
            this.numero = numero;
        }

        public Hilo(ColaBloqueo<Integer> cola, int numero, boolean insertar) {
            this.cola = cola;
            this.numero = numero;
            this.insertar = insertar;
        }

        @Override
        public void run() {

            Random r = new Random();
            int random_number = r.nextInt(2);

            if (random_number == 0) {
                cola.insertar(numero);
            } else {
                cola.remover();
            }

        }

    }

    public static class ColaBloqueo<E> {

        private int max;
        private LinkedList<E> cola;
        private ReentrantLock bloqueo = new ReentrantLock(true);
        private Condition noVacio = bloqueo.newCondition();
        private Condition noLleno = bloqueo.newCondition();

        public ColaBloqueo(int max) {
            this.max = max;
            this.cola = new LinkedList<>();
        }

        public void insertar(E element) {

            bloqueo.lock();

            try {

                while (cola.size() == max) {
                    noLleno.wait();
                }

                cola.add(element);
                System.out.println("Se inserto en : [" + cola.size() + "] - valor : " + element);
                interfaz.changeJLabelEntrega(String.valueOf(element), cola.size() - 1);
                noVacio.signalAll();

            } catch (Exception e) {

            } finally {
                bloqueo.unlock();
            }
        }

        public E remover() {
            bloqueo.lock();

            try {

                while (cola.size() == 0) {
                    noVacio.wait();
                }

                E element = cola.remove();
                System.out.println("Se removio en : [" + cola.size() + "] - valor : " + element);
                interfaz.changeJLabelRecoje(String.valueOf(element), cola.size());
                noLleno.signalAll();
                return element;

            } catch (Exception e) {

                return null;
            } finally {
                bloqueo.unlock();
            }

        }

        public void print() {
            for (int i = 0; i < this.cola.size(); i++) {
                System.out.println("Se inserto en : [" + i + "] - valor : " + cola.get(i));
            }
        }

    }
}
