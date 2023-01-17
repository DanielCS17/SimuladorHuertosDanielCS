import com.simuladorHuertos.resources.Huerto;
import com.simuladorHuertos.threads.Cliente;
import com.simuladorHuertos.threads.Productor;

public class Main {

    public static void main(String[] args) {
        Huerto huerto = new Huerto(5);

        Productor productor = new Productor("Don Bosco", 5, 4, huerto);
        Cliente daniel = new Cliente("Daniel", 5, 4, huerto);

        productor.setPriority(3);
        productor.start();
        daniel.start();
    }
}