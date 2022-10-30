package Model;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DadosTest.class,
	JogadorTest.class,
	CartasTest.class,
	SuspeitaTest.class,
	TabuleiroTest.class,
})
public class ModelTest {}