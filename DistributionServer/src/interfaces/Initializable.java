package interfaces;

/**
 * Created by Sebastían on 16/12/2016.
 */
public interface Initializable<Initialize, Stop> {

    /**
     * This method takes care of the initialization of
     * classes that have implemented this interface
     * @return  the Initialize
     */
    Initialize initialize();

    /**
     * This method takes care of the stop of whatever
     * class is willing to implement this interface
     * @return  the Stop
     */
    Stop stop();
}
