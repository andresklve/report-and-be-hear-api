package pe.edu.upc.reportandbeheard.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Report And Be Heard API",
                version = "1.0.0",
                description = "API para la gestión de testimonios, zonas, roles, usuarios y moderaciones del sistema."
        ),
        tags = {
                @Tag(name = "Testimonios", description = "Gestión de testimonios del sistema."),
                @Tag(name = "Zonas", description = "Gestión de zonas geográficas."),
                @Tag(name = "Roles", description = "Gestión de roles del sistema."),
                @Tag(name = "Usuarios", description = "Gestión de usuarios del sistema."),
                @Tag(name = "Categorías", description = "Gestión de categorías de testimonios.")
        }
)
public class OpenApiConfig {
}
