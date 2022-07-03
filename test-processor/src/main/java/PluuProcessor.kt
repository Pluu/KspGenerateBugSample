import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.google.devtools.ksp.validate

class PluuProcessor(
    val codeGenerator: CodeGenerator,
    val options: Map<String, String>,
    val logger: KSPLogger
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation("com.pluu.annotation.PluuSample")
        val ret = symbols.filter { !it.validate() }.toList()
        symbols
            .filter { it is KSPropertyDeclaration && it.validate() }
            .forEach { it.accept(BuilderVisitor(), Unit) }
        return ret
    }

    inner class BuilderVisitor : KSVisitorVoid() {
        override fun visitPropertyDeclaration(property: KSPropertyDeclaration, data: Unit) {
            super.visitPropertyDeclaration(property, data)

            val propertyName = property.simpleName.asString()
            val resolvedType = property.type.resolve()
//            val propertyType = resolvedType.declaration.simpleName.asString()
            val propertyType = resolvedType.declaration.qualifiedName!!.asString()

            logger.warn(
                ">> property: $propertyName : $propertyType",
                property
            )
        }
    }
}

class PluuProcessorProvider : SymbolProcessorProvider {
    override fun create(
        env: SymbolProcessorEnvironment
    ): SymbolProcessor {
        return PluuProcessor(env.codeGenerator, env.options, env.logger)
    }
}