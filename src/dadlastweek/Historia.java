/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadlastweek;

import java.awt.Image;
import java.util.Stack;
import javax.swing.ImageIcon;

/**
 *
 * @author Aula1
 */
//-2 cuando pierde varios, -1 cuando pierde un objeto, 0 cuando no gana nada, 1 cuando gana un objeto, 2 cuando gana varios, 3 gana y pierde

public class Historia {
    private Decision history;
    String[] objs = {"O00", "O01", "O02", "O03", "O04"};
    
    public Historia(){
        //Prólogo
        history = new Decision("Es una tarde cualquiera, llegas de trabajar para el reino de Esbostia, "
                + "de pronto, un mensajero toca a tu puerta, te das cuenta por como viste que es de tu tierra natal"
                + " y que trae una carta urgente para ti, la recibes, te sientas a leerla. Al cabo de unos minutos,"
                + " unas lágrimas pasan por tu mejilla, te levantas y comienzas a empacar. En cuanto sales de tu casa,"
                + " comienzas a correr.\n\nLa carta decía:\n\n“Hola hijo, hace tiempo que no hablamos, pero parece que no me queda"
                + " mucho tiempo en este mundo. El doctor del pueblo dijo que seguramente no duraré mucho, esta será"
                + " mi última semana y como mi último deseo quiero ver a mi hijo una última vez.\nPara cuando recibas"
                + " esta carta, sólo me quedará una semana de vida. Te espero con ansias.\n\nCon amor, tu padre”.", null, "D000",
                null, 100, "Normal", null, null, null);//Obtiene objetos espada y lanza
        //Día 1
        //Decisiones 1
        history.left = new Decision("Este es un viaje duradero, apenas pudiste empacar comida para dos días,"
                + " corres por el camino, pero te advierten que por ese camino unos bandidos merodean y es riesgoso, "
                + "puedes tomar un atajo por el bosque, pero hay que tener cuidado de las bestias salvajes. Para defenderte"
                + " tienes solamente una espada y una lanza, ¿por cuál camino irás?", "A001", "D001", 
                "O00,O01,O02,O03,O04", 100, "Normal", null, null, null);
        //Decisiones 2
        history.left.left = new Decision("Corres por el bosque escuchando ruidos extraños, te cortas con una rama"
                + " en él brazo, ves que puede ser grave, está empezando a sangrar, puedes tapar la herida con unas hojas"
                + " que encuentras, ¿o seguirás atravesando sin darle importancia?", "A002", "D001",
                null, 100, "Asustado", bosquebtn1, bosquebtn2, bosquebtn3);
        history.left.right = new Decision("Sin temor eliges el camino y corres atento por cualquier bandido que veas,"
                + " mientras caminas, te das cuenta de que no eran nada más que simples rumores, se hace la tarde y tratas"
                + " de dormir debajo de uno de los letreros del camino.", "A003", "D001",
                "-O03", 100, "Asustado", caminobtn1, caminobtn2, caminobtn3);
        //Decisiones 3
        history.left.left.left = new Decision("Sigues corriendo por el bosque, arrancas una parte de tu ropa para"
                + " vendar la herida y detener el sangrado, te sientes algo cansado, decides reposar y dormir un poco.",
                "A004", "D001", "O06,-O03", 70, "Cansado", nohacernadabtn1, nohacernadabtn2, nohacernadabtn3);
        history.left.left.right = new Decision("Te tapas la herida con una hoja que se adhieren a tu brazo, sientes "
                + "un poco de picor, pero vez que la hemorragia paró, corres y sales por fin del bosque, "
                + "te sientes algo cansado, decides reposar y dormir un poco.", "A005", "D001",
                "O05,-O03", 70, "Cansado", tratarheridabtn1, tratarheridabtn2, tratarheridabtn3);
        //Día 2
        //Decisiones 1
        history.left.left.left.left = new Decision("Te levantas, tu herida sigue un poco mal, has empezado a escuchar que"
                + " las bestias están más cerca, solo corres para que no te atrapen.", "A006", "D002",
                "O03", 72, "Asustado", null, null, null);
        history.left.left.right.left = new Decision("Te levantas, estás completamente mareado y a punto de perder la conciencia,"
                + " tu herida se ha infectado aún más, estas demasiado cansado para hacer algo hoy. Te recuestas para"
                + " descansar un poco.", "A007", "D002",
                "O03", 40, "Mareado", null, null, null);
        history.left.right.left = new Decision("Te levantas normalmente, comes parte de tu comida y sigues por tu camino, "
                + "mientras tanto ves que hay un anciano tirado en el piso, parece desmayado, ¿quieres ayudarlo?", 
                "A008", "D002", "O03", 100, "Normal", null, null, null);
        //Decisiones 2
        history.left.right.left.left = new Decision("Te acercas hacia el anciano, le preguntas si esta bien, "
                + "pero no hay respuesta, lo quieres mover, pero cuando lo tocas, alguien te golpea con un mazo"
                + " justo en la cabeza y quedas inconsciente.", "A009", "D002", 
                null, 60, "Inconsciente", ayudarlobtn1, ayudarlobtn2, ayudarlobtn3);
        history.left.right.left.right = new Decision("Tras mirarlo detenidamente, ese anciano luce algo sospechoso, "
                + "y sabes que por estos sitios no se debe confiar mucho en la gente, por lo que corres por el camino"
                + " hasta llegar al pueblo más cercano.", "A010", "D002", 
                null, 100, "Normal", seguirbtn1, seguirbtn2, seguirbtn3);
        //Día 3
        //Decisiones 1
        history.left.left.left.left.left = new Decision("No tienes idea de cuánto tiempo llevas corriendo, "
                + "el miedo a ser comido ha hecho que no sientas la fatiga de correr, pero pronto te ves rodeado de "
                + "4 lobos, tu herida los atrajo y quieren cazarte, puedes tratar de enfrentarlos o seguir corriendo, "
                + "¿qué harás?", "A011", "D003", null, 65, "Asustado", null, null, null);
        history.left.right.left.right.left = new Decision("Llegaste al pueblo, tu comida pronto se acabará miras que "
                + "un niño cerca de su casa se ha caído, está llorando y lo ayudas. Como agradecimiento, sus padres te"
                + " ofrecen posada y comida y, si les ayudas con las compras de mañana, puede que pierdas tiempo haciendo"
                + " esta obra, ¿sacrificaras parte de tu tiempo por una buena obra?", "A012", "D003", 
                "-O02", 100, "Normal", null, null, null);
        //Decisiones 2
        history.left.left.left.left.left.left = new Decision("Con todo el coraje por tus manos, tomas tu espada y te "
                + "enfrascas en una pelea, logras asestar unos cuantos golpes, parece que has matado a uno de los lobos, "
                + "pero no es suficiente, aparecen más lobos y te van superando en número, te estas quedando"
                + " completamente acorralado y sin energía, parece que esto no saldrá muy bien.", "A013", "D003", 
                "-O00", 40, "Asustado", pelearbtn1, pelearbtn2, pelearbtn3);
        history.left.left.left.left.left.right = new Decision("Sabes que por mucho que pelees no podrás ganar esta batalla,"
                + " por lo que les tiras tu odre lleno de agua con toda tu fuerza para distraerlos y tan pronto como los "
                + "golpea, empiezas a correr con todas tus fuerzas sin mirar atrás, corres hasta que dejas de escuchar "
                + "los ruidos de las bestias. Te sientes cansado y un poco desorientado.", "A014", "D003",
                "-O04", 40, "Cansado", huirbtn1, huirbtn2, huirbtn3);
        history.left.right.left.right.left.left = new Decision("Aceptas su invitación, después de todo estás algo hambriento, "
                + "juegas con los niños, hablas un poco con los padres de tu situación y te dicen que mañana te darán una "
                + "sorpresa, después de la cena te ofrecen una cama, y duermes plácidamente.", "A015", "D003",
                null, 100, "Normal", aceptarbtn1, aceptarbtn2, aceptarbtn3);
        history.left.right.left.right.left.right = new Decision("Cordialmente rechazas su invitación, después de todo no "
                + "quieres perder nada de tiempo, te dan las gracias, tal cual sigues con tu camino, comienzas a correr "
                + "porque se acerca la noche, encuentras unos troncos y haces una fogata, estas cada vez más cerca de tu "
                + "destino.", "A016", "D003", "-O03", 100, "Normal", rechazarbtn1, rechazarbtn2, rechazarbtn3);
        //Día 4
        //Decisiones 1
        history.left.left.left.left.left.right.left = new Decision("La espesura del bosque no te deja diferenciar cuánto ha "
                + "pasado, pero te estás quedando sin aliento. De pronto, un lobo alcanza a saltar sobre ti, te ha mordido en "
                + "el brazo de la herida, mientras te tratas de zafarse de esto, éste llama a más lobos, no sabes cómo "
                + "reaccionar ante esto, los mueves con tu lanza para sacarlos de encima. ¿Este será tal vez tu fin?", 
                "A017", "D004", "-O01", 20, "Hemorragia", null, null, null);
        history.left.left.right.left.left = new Decision("Has pasado dos días desmayado, simplemente no puedes levantarte, "
                + "tienes náuseas, vértigo, no sabes donde estás y comienzas a alucinar con que has visto el camino "
                + "cuando no hay nada enfrente de ti, tienes sed, hambre y fatiga, empiezas a sudar, de pronto escuchas una "
                + "voz diciendo: \n-“Ven hijo mío…”.", "A018", "D004", null, 10, "Envenenado", null, null, null);
        history.left.right.left.right.left.left.left = new Decision("Ya es de mañana, te levantas, algo angustiado por tu"
                + " falta de tiempo, ayudas en las tareas de la casa, vas a hacer las compras, pero aun así sigues "
                + "angustiándote, los padres se percatan de ello y te dicen que no tienes de qué preocuparte,"
                + "que está todo preparado, así que confías en ellos y te vas a dormir.", "A019", "D004", 
                null, 100, "Tranquilo", null, null, null);
        history.left.right.left.right.left.right.left = new Decision("Te levantas con algo de hambre, consigues unos "
                + "arándanos, vas por algo de agua en un riachuelo, mientras sigues por el camino, ves una multitud de gente,"
                + " uno de ellos te advierte de no seguir ¿Por qué será?", "A020", "D004", 
                "O07,O03", 100, "Normal", null, null, null);
        //Día 5
        //Decisiones 1
        history.left.left.left.left.left.right.left.left = new Decision("Te despiertas, aún no entiendes qué pasó, estás "
                + "sangrando por todos lados, se han comido tu brazo parcialmente, estás muy malherido, ves una carreta y pides "
                + "ayuda con tu útimo aliento, gritas con todas tus fuerzas para que te auxilien, pero te vuelves a desmayar.",
                "A021", "D005", null, 10, "Hemorragia", null, null, null);
        history.left.right.left.left.left = new Decision("Te levantas con un fuerte dolor en tu cabeza, te han robado todo "
                + "lo que tienes, no sabes por cuántos días has estado inconsciente, te levantas, tratas de ubicarte, "
                + "sabes que estas un poco lejos, pero igual corres con todas tus fuerzas con las esperanzas de "
                + "llegar a tiempo.", "A022", "D005", "-O00,-O01,-O02,-O03,-O04", 50, "Mareado", null, null, null);
        history.left.right.left.right.left.left.left.left = new Decision("Una vez amanece, te levantas y te dicen que te "
                + "alistes, además, por toda tu ayuda, ellos te consiguen una carreta que te llevará en unas cuantas "
                + "horas a tu destino, les agradeces mucho por este valioso gesto, procedes a subirte y esperas a que te "
                + "lleve con tu padre.", "A023", "D005", null, 100, "Tranquilo", null, null, null);
        history.left.right.left.right.left.right.left.left = new Decision("El aldeano te advirtió ayer que aquí adelante "
                + "había un derrumbe de piedras por lo que ahora tienes dos opciones, subir la montaña, o pasar por el lago."
                + " Se cuenta un rumor que un hada habita ese lago, ¿cuál será tu decisión?", "A024", "D005",
                null, 100, "Normal", null, null, null);
        //Decisiones 2
        history.left.right.left.right.left.right.left.left.left = new Decision("Subes por la montaña, parece algo peligroso, "
                + "pero te enfrascas en peligros. Empiezas a tener frio y, a una considerable altura, comienzas a temer "
                + "caerte, pero sigues con la voluntad de llegar a tu destino y continuas escalando.", "A025", "D005",
                null, 70, "Asustado", montanabtn1, montanabtn2, montanabtn3);
        history.left.right.left.right.left.right.left.left.right = new Decision("Bajas por los escombros en busca del lago"
                + " y del hada, entras con la rectitud y valentía, para afrontar al hada. Quizás ella tenga algo que pueda "
                + "ayudarte, o al contrario, perjudicarte.", "A026", "D005",
                null, 100, "Normal", lagobtn1, lagobtn2, lagobtn3);
        //Día 6
        history.left.left.left.left.left.right.left.left.left = new Decision("Te van llevando con tus heridas donde tu "
                + "padre, ellos dicen que no tiene sentido que estés muy herido y posiblemente no dures el viaje, pero no "
                + "te importa, solamente quieres llegar a toda costa. Te desmayas por la pérdida de sangre.", "A027",
                "D006", null, 5, "Moribundo", null, null, null);
        history.left.right.left.left.left.left = new Decision("Sigues corriendo por quién sabe cuánto tiempo, gastas toda "
                + "tu energía, estás aún muy lejos de tu destino, pero consigues encontrar un atajo siguiendo un arroyo, "
                + "parece que puedes acortar algo del tiempo perdido, pero ¿será suficiente?", "A028", "D006",
                null, 50, "Cansado", null, null, null);
        history.left.right.left.right.left.right.left.left.left.left = new Decision("Consigues atravesar la montaña, ves que "
                + "a lo lejos está tu tierra natal, la tierra donde naciste y creciste, te llenas de emoción porque tras 5 "
                + "largos días de una dura aventura ahí veías a tu pueblo, te pones de pie y comienzas a descender para "
                + "llegar por fin con tu amado padre.", "A029", "D006", null, 70, "Normal", null, null, null);
        history.left.right.left.right.left.right.left.left.right.left = new Decision("En medio del lago ves que se empieza "
                + "a formar una espesa niebla la cual te impide ver cualquier cosa enfrente de ti, luego escuchas un susurro "
                + "a lo lejos: \n-“¿A qué has venido viajero? ¿Por qué noto que tu alma siente dolor?”'\nExplicas la situación "
                + "de tu padre, y que harás todo lo posible para ayudarlo, el hada te propone una propuesta: \n-“Por tan "
                + "largo tiempo y aventura que has dado, una oferta yo te hago, a tu amado padre puedo yo curar más una "
                + "condición has de ajustar, llévale esta agua que su enfermedad podrá curar, pero un alto precio has de dar,"
                + " detalles voy a ocultar para que así la magia pueda funcionar”. \nNo te importa y tomas la botella con el "
                + "agua que el hada te dió, atraviesas la niebla y puedes deslumbrar que estás a las afueras de tu pueblo, "
                + "corres para encontrar tu casa donde está tu padre.", "A030", "D006",
                "O08", 100, "Tranquilo", null, null, null);
        //Día 7
        //Finales
        history.left.left.left.left.left.left.left = new Decision("Llevas horas batallando, pero los lobos sólo son más "
                + "y más, no sabes cómo puedes salir de esta, pero te estas cansando, no puedes hacer nada, te rindes y "
                + "aceptas tu destino, los lobos aúllan pues hoy consiguieron más comida para su manada. Al tiempo, los "
                + "cazadores del reino encuentran tu cuerpo despedazado y perdido, mientras tu padre falleció con la "
                + "idea de que su hijo no quiso ir a visitarlo.", "A031", "D007", null, 0, "Muerto", null, null, null);
        history.left.left.left.left.left.right.left.left.left = new Decision("Una carreta llega a toda la velocidad, "
                + "te bajas y corres con tus últimas fuerzas hasta por fin abrir la puerta de su casa, ahí se encuentra "
                + "tu padre y al doctor que te dice que no le queda mucho tiempo, lo saludas con lágrimas en los ojos, "
                + "le dices que todo va estar bien que estarán juntos por siempre, tú y tu padre se sienten cansados y "
                + "deciden despedirse con un casual “buenas noches, hasta mañana”, y ambos duermen para nunca más despertar."
                + "\nCon tristeza, el pueblo hoy entierra a un padre y a su hijo.", "A032", "D007",
                null, 0, "Muerto", null, null, null);
        history.left.left.right.left.left.left = new Decision("Para este entonces tu cuerpo ya no responde, estas caminando "
                + "y no sabes dónde, no sientes tu brazo, la fatiga te ciega, te cuesta respirar mientras sientes como el "
                + "pecho te quema como si estuvieras en llamas, caes al piso en pleno shock mientras convulsionas hasta que "
                + "tu corazón deja de latir, pasa el tiempo pero nadie encuentra tu cuerpo, pues es absorbido entre las "
                + "malezas del bosque, mientras tanto tu padre falleció con la idea de que su hijo no quiso ir a visitarlo.",
                "A033", "D007",
                null, 0, "Muerto", null, null, null);
        history.left.right.left.left.left.left.left = new Decision("Sigues corriendo, han pasado días hasta que por fin "
                + "llegas a tu pueblo, ruegas a los dioses que por favor no llegues tarde, que te quede algo de tiempo, "
                + "pero justo cuando llegas a la plaza ves que están llevando un cuerpo para enterrarlo, te tiras al suelo "
                + "y lo golpeas con todas tus fuerzas porque no pudiste llegar, lloras mientras un aldeano te dice que "
                + "tu padre falleció con la idea de que su hijo no quiso ir a visitarlo.", "A034", "D007",
                null, 50, "Depresión", null, null, null);
        history.left.right.left.right.left.left.left.left.left = new Decision("Por fin has llegado y en un menor tiempo del "
                + "esperado. Abres la puerta en la cual tu padre se alegra, según el doctor no le quedan más de dos días "
                + "pero aun así no te separas de su lado. \nLe cuentas historias de los caballeros del reino, aventuras de "
                + "gladiadores, comentas sobre aquella familia que ayudaste y como llegaste hasta aquí, pasa el tiempo, "
                + "y tu padre te comenta lo alegre que está por que estés aquí, que con gran orgullo se va de este mundo "
                + "porque hizo lo correcto con su hijo. \nTan pronto como acaba de decir sus palabras, la mano que sostenías "
                + "pierde fuerza y se escucha un último aliento por parte de el que alguna vez te educó y amo. Con tristeza"
                + " en tu corazón, proceden a enterrarlo al día siguiente, pero sabes que hiciste todo lo posible para "
                + "visitarlo y lo lograste, sabes que ahora tu padre no sufrirá jamás dado que está en un lugar mejor "
                + "siendo honrado por los dioses como el valiente caballero que alguna vez fue.", "A035", "D007",
                null, 100, "Tranquilo", null, null, null);
        history.left.right.left.right.left.right.left.left.left.left.left = new Decision("Estas algo sucio y cansado por "
                + "escalar tremenda montaña más no te importa, el doctor te dice que no hay mucho tiempo, sostienes la "
                + "mano de tu padre, y le dices que lamentas no haberlo visitado, que realmente hiciste todo lo que pudiste "
                + "para venir lo más antes posible. \nEl te perdona porque te quiere y sabe que dices la verdad, te halaga "
                + "por haberte convertido en el hombre que hoy eres y que se siente honrado de que pueda verte una vez más, "
                + "aún quieres hablar más con él, pero su voz se detiene de pronto, su pulso ya no corre, no lo entiendes, "
                + "y simplemente lloras al pie de su cama.", "A036", "D007", null, 70, "Triste", null, null, null);
        history.left.right.left.right.left.right.left.left.right.left.left = new Decision("Tan pronto como llegas a su casa "
                + "tu padre te mira y se alegra, tu preocupado por él le cuentas lo que viste con el hada, y le dices que "
                + "beba el agua que esta te dio, tu padre confía en ti, y bebe el agua mientras que el doctor lo mira "
                + "asombrado, pues nunca antes había presenciado magia en este mundo. \nLuego, parece que la enfermedad "
                + "de tu padre fue completamente curada por completo, lo miras y te ves realmente feliz. Con lágrimas "
                + "quieres abrazarlo , pero él te detiene y te dice: \n-“¿Quién eres?” \nNo entiendes que pasa, pero tu "
                + "padre se levanta y saluda a todos por su nombre con toda la gratitud pero a ti parece no reconocerte. "
                + "En ese momento recuerdas las palabras de esa hada, y es ahora que entiendes cuál era el precio a pagar, "
                + "lloras en el suelo y luego abandonas tu pueblo, sabes que en fondo hiciste lo correcto porque tu padre "
                + "está curado, a pesar de que ahora vive con la idea de que nunca tuvo un hijo.", "A037", "D007",
                "-O08", 100, "Depresión", null, null, null);
    }

    public Decision getHistory() {
        return history;
    }

    public void setHistory(Decision history) {
        this.history = history;
    }
    
    public String obtenerDia(String day){
        String dia2 = day.replace(String.valueOf(day.charAt(0)), "");
        int day2 = Integer.parseInt(dia2);
        if(day2 == 0){
            return "Prólogo";
        }else{
            return "Día "+day2;
        }
    }
    
    public Decision obtenerDecision(String decision){
        Decision aux = history;
        Stack<Decision> stack = new Stack<>();
        
        while(aux != null){
            stack.push(aux);
            aux = aux.left;
        }
        while(!stack.isEmpty()){
            aux = stack.pop();
            if(aux.decision.equals(decision)){
                return aux;
            }
            aux = aux.right;
            while(aux != null){
                stack.push(aux);
                aux = aux.left;
            }
        }
        return null;
    }
    
    //Botones
    protected Image caminobtn1 = new ImageIcon(getClass().getResource("/images/Camino 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image caminobtn2 = new ImageIcon(getClass().getResource("/images/Camino 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image caminobtn3 = new ImageIcon(getClass().getResource("/images/Camino 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image bosquebtn1 = new ImageIcon(getClass().getResource("/images/Bosque 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image bosquebtn2 = new ImageIcon(getClass().getResource("/images/Bosque 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image bosquebtn3 = new ImageIcon(getClass().getResource("/images/Bosque 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    
    protected Image nohacernadabtn1 = new ImageIcon(getClass().getResource("/images/No hacer nada 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image nohacernadabtn2 = new ImageIcon(getClass().getResource("/images/No hacer nada 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image nohacernadabtn3 = new ImageIcon(getClass().getResource("/images/No hacer nada 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image tratarheridabtn1 = new ImageIcon(getClass().getResource("/images/Herida 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image tratarheridabtn2 = new ImageIcon(getClass().getResource("/images/Herida 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image tratarheridabtn3 = new ImageIcon(getClass().getResource("/images/Herida 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    
    protected Image ayudarlobtn1 = new ImageIcon(getClass().getResource("/images/Ayudarlo 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image ayudarlobtn2 = new ImageIcon(getClass().getResource("/images/Ayudarlo 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image ayudarlobtn3 = new ImageIcon(getClass().getResource("/images/Ayudarlo 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image seguirbtn1 = new ImageIcon(getClass().getResource("/images/Seguir 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image seguirbtn2 = new ImageIcon(getClass().getResource("/images/Seguir 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image seguirbtn3 = new ImageIcon(getClass().getResource("/images/Seguir 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
            
    protected Image pelearbtn1 = new ImageIcon(getClass().getResource("/images/Pelear 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image pelearbtn2 = new ImageIcon(getClass().getResource("/images/Pelear 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image pelearbtn3 = new ImageIcon(getClass().getResource("/images/Pelear 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image huirbtn1 = new ImageIcon(getClass().getResource("/images/Huir 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image huirbtn2 = new ImageIcon(getClass().getResource("/images/Huir 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image huirbtn3 = new ImageIcon(getClass().getResource("/images/Huir 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
            
    protected Image aceptarbtn1 = new ImageIcon(getClass().getResource("/images/Aceptar 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image aceptarbtn2 = new ImageIcon(getClass().getResource("/images/Aceptar 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image aceptarbtn3 = new ImageIcon(getClass().getResource("/images/Aceptar 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image rechazarbtn1 = new ImageIcon(getClass().getResource("/images/Rechazar 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image rechazarbtn2 = new ImageIcon(getClass().getResource("/images/Rechazar 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image rechazarbtn3 = new ImageIcon(getClass().getResource("/images/Rechazar 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
            
    protected Image montanabtn1 = new ImageIcon(getClass().getResource("/images/Montaña 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image montanabtn2 = new ImageIcon(getClass().getResource("/images/Montaña 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image montanabtn3 = new ImageIcon(getClass().getResource("/images/Montaña 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image lagobtn1 = new ImageIcon(getClass().getResource("/images/Lago 1.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image lagobtn2 = new ImageIcon(getClass().getResource("/images/Lago 2.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
    protected Image lagobtn3 = new ImageIcon(getClass().getResource("/images/Lago 3.png")).getImage().getScaledInstance(150, 80, Image.SCALE_AREA_AVERAGING);
}
