import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.Triangulo;
import com.TypeTriangle;

public class TestTriangulo {

	@Test
	void testIsEquilatero() {
		TypeTriangle type = Triangulo.getType(1f, 1f, 1f);
		assertTrue(type.equals(TypeTriangle.EQUILATERO));
	}

	@Test
	void testIsIsosceles() {
		TypeTriangle type = Triangulo.getType(1f, 1f, 2f);
		assertTrue(type.equals(TypeTriangle.ISOSCELES));
	}

	@Test
	void testIsEscaleno() {
		TypeTriangle type = Triangulo.getType(1f, 2f, 3f);
		assertTrue(type.equals(TypeTriangle.ESCALENO));
	}
}
