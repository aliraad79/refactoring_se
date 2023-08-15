# MiniJava
Mini-Java is a subset of Java. MiniJava compiler implement a compiler for the Mini-java
programming language.

# Rules
```
Goal --> Source EOF
Source --> ClassDeclarations MainClass
MainClass --> class Identifier { public static void main() { VarDeclarations Statements}}
ClassDeclarations --> ClassDeclaration ClassDeclarations | lambda
ClassDeclaration --> class Identifier Extension { FieldDeclarations MethodDeclarations }
Extension --> extends Identifier | lambda
FieldDeclarations --> FieldDeclaration FieldDeclarations | lambda
FieldDeclaration --> static Type Identifier ;
VarDeclarations --> VarDeclaration VarDeclarations | lambda
VarDeclaration --> Type Identifier ;
MethodDeclarations --> MethodDeclaration MethodDeclarations | lambda
MethodDeclaration --> public static Type Identifier ( Parameters ) { VarDeclarations Statements return GenExpression ; }
Parameters --> Type Identifier Parameter | lambda
Parameter --> , Type Identifier Parameter | lambda
Type --> boolean | int
Statements --> Statements Statement | lambda
Statement --> { Statements } | if ( GenExpression ) Statement else Statement | while ( GenExpression ) Statement | System.out.println ( GenExpression ) ; | Identifier = GenExpression ;
GenExpression --> Expression | RelExpression
Expression --> Expression + Term | Expression - Term | Term
Term --> Term * Factor | Factor
Factor --> ( Expression ) | Identifier | Identifier . Identifier | Identifier . Identifier ( Arguments ) | true | false | Integer
RelExpression --> RelExpression && RelTerm | RelTerm
RelTerm --> Expression == Expression | Expression < Expression
Arguments --> GenExpression Argument | lambda
Argument --> , GenExpression Argument | lambda
Identifier --> <IDENTIFIER_LITERAL>
Integer --> <INTEGER_LITERAL>
```
سوال یک
کد تمیز چیست؟
کد تمیز، کدی است که با رعایت بهترین روش‌ها و استانداردهای برنامه‌نویسی نوشته شده است. این نوع کد، خوانایی بالایی دارد و به راحتی قابل توسعه و تغییر است. با کد تمیز، توسعه‌دهندگان می‌توانند به راحتی نیازمندی‌های جدید را پیاده‌سازی کنند و خطاها را کمتر مشاهده کنند.

بدهی فنی چیست؟
بدهی فنی به مشکلات و نقص‌های فنی در یک سیستم یا نرم‌افزار اشاره دارد. این مشکلات می‌توانند به علت عدم رعایت استانداردها، مشکلات عملکردی یا خطاهای دیگر باشند. بدهی فنی می‌تواند باعث شود توسعه و نگهداری نرم‌افزار سخت‌تر شود.

بوی بد در برنامه‌نویسی چیست؟
بوی بد، نشانه‌هایی از مشکلات و نقص‌های موجود در کد است که ممکن است به طور مستقیم قابل مشاهده نباشند. این نشانه‌ها می‌توانند به نقاط ضعف یا مشکلات پنهان در کد اشاره داشته باشند که نیاز به بازسازی دارند.

سوال ۲
بوهای بد در برنامه‌نویسی:

بلوترها: این بوها نشان‌دهنده نقص‌ها و مشکلاتی در کد هستند که باعث می‌شوند کد پیچیده‌تر و سخت‌تر قابل فهم شود.
سو استفاده از شیء-گرایی: این بوها نشان‌دهنده استفاده نادرست از مفاهیم شیء-گرایی در کد هستند.
مانع‌های تغییر: این بوها به موانعی اشاره می‌کنند که جلوی تغییرات و بهبود در کد را می‌گیرند.
غیرضروری‌ها: این بوها به قسمت‌هایی از کد اشاره دارند که می‌توان آنها را حذف کرد.
اتصال‌گرها: این بوها به وابستگی‌های نامناسب بین قسمت‌های مختلف کد اشاره دارند.
سوال ۳
چگونه بوی بد "Lazy Class" را می‌توان حل کرد؟

دستهی چهارم
Inline Class: اگر یک کلاس فاقد وظیفه خاصی است، می‌توان محتوای آن را در کلاس دیگری ادغام کرد.
Collapse Hierarchy: اگر یک کلاس فقط یک سطح از یک سلسله مراتب را تشکیل می‌دهد، می‌توان آن را با کلاس‌های دیگر ادغام کرد.

در این موارد، می‌توان از حذف کلاس‌های "Lazy" خودداری کرد.
آماده‌سازی برای توسعه آتی: کلاس‌هایی که برای وظایف آتی ایجاد شده‌اند.
رعایت استانداردها یا الگوهای طراحی: کلاس‌هایی که بر اساس الگوهای خاص طراحی شده‌اند.
جداسازی مسئولیت‌ها: کلاس‌هایی که برای جداسازی وظایف ایجاد شده‌اند.
وجود مستندات: کلاس‌هایی که دلیل وجود آن‌ها در مستندات توضیح داده شده است.
