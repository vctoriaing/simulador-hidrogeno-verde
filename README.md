# H2 Visual Lab: Simulador de Hidrógeno Verde

## Descripción del Proyecto
**H2 Visual Lab** es una aplicación de escritorio desarrollada en **Java** que simula el proceso de electrólisis del agua para la producción de hidrógeno verde. Este proyecto interdisciplinario integra la **Programación Orientada a Objetos (POO)** con modelos matemáticos de **Cálculo y Química** para resolver problemas energéticos reales.

El software permite a los usuarios configurar variables operativas (voltaje, corriente, tiempo) y visualizar en tiempo real cómo afectan la eficiencia, la producción de hidrógeno y la reducción de huella de carbono ($CO_2$).

## Características Técnicas
* **Motor Gráfico Personalizado:** Implementación de visualización de datos utilizando `Java Swing` y la clase `Graphics2D`. Se sobrescribió el método `paintComponent` para renderizar curvas de eficiencia sin depender de librerías de gráficos externas.
* **Arquitectura Modular (POO):** Diseño desacoplado basado en 3 responsabilidades principales:
    * `ParametroSimulado`: Validación y gestión de inputs.
    * `ModeloElectrolisis`: Lógica de negocio basada en la Ley de Faraday y balances energéticos.
    * `ResultadoSimulado`: Procesamiento y encapsulamiento de métricas de salida.
* **Optimización Matemática:** Integración de algoritmos de cálculo diferencial para encontrar puntos de operación óptimos (máxima eficiencia energética).

## Tecnologías Utilizadas
* **Lenguaje:** Java (JDK 17)
* **IDE:** Apache NetBeans
* **Interfaz:** Java Swing (AWT)
* **Conceptos:** Herencia, Encapsulamiento, Modelado Matemático.

## Métricas de Simulación
El sistema calcula y valida científicamente:
1.  **Producción:** Masa de $H_2$ generada (basada en carga eléctrica).
2.  **Eficiencia:** Relación entre energía teórica vs. real consumida.
3.  **Impacto Ambiental:** Toneladas de $CO_2$ evitadas en comparación con la producción de hidrógeno gris.

## Estructura del Código
El proyecto sigue un diseño limpio donde la lógica de simulación está separada de la interfaz visual, permitiendo escalabilidad para futuros modelos de electrólisis (AEM, SOEC).

---
*Proyecto desarrollado como parte de la Evaluación de Proceso Integrado (EPI) - Ingeniería Civil Informática.*
