import com.simuladorHuertos.resources.Huerto;
import com.simuladorHuertos.threads.Cliente;
import com.simuladorHuertos.threads.Productor;

public class Main {

    public static void main(String[] args) {
        Huerto huerto = new Huerto(5);

        Productor productor = new Productor("Don Bosco", 5, 5, huerto);
        Cliente daniel = new Cliente("Daniel", 5, 5, huerto);

        productor.start();
        daniel.start();
    }
}