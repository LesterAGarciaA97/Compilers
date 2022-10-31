package gt.edu.url;

import java.util.HashMap;
import java.util.Map;

    public class MyExprVisitor extends ExprBaseVisitor<Double>{
        Map<String, Double> memory = new HashMap<>();
        @Override
        public Double visitAssign(ExprParser.AssignContext ctx){
            String id = ctx.ID().getText();
            double value = visit(ctx.expr());
            memory.put(id, value);
            return value;
        }
        @Override
        public Double visitPrintExpr(ExprParser.PrintExprContext ctx){
            Double value = visit(ctx.expr());
            System.out.println(value);
            return value;
        }
        @Override
        public Double visitId(ExprParser.IdContext ctx){
            String id = ctx.ID().getText();
            if(memory.containsKey(id)) return memory.get(id);
            return 0.0;
        }
        @Override
        public Double visitInt(ExprParser.IntContext ctx){
            return Double.valueOf(ctx.INT().getText());
        }
        @Override
        public Double visitDouble(ExprParser.DoubleContext ctx){
            return Double.valueOf(ctx.DOUBLE().getText());
        }
        @Override
        public Double visitAcumu(ExprParser.AcumuContext ctx){
            String value = ctx.getText();
            value = value.replace("++", "");
            Double right = Double.valueOf(value);
            return right+1.0; //Se le suma 1.0 al numero que se encuentra a la derecha
        }
        @Override
        public Double visitPot(ExprParser.PotContext ctx){
            //Aqui si se necesita ambos lados de expr
            Double left = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            Double potenciaTotal = Math.pow(left,right);
            return potenciaTotal;
        }
        @Override
        public Double visitMultDiv(ExprParser.MultDivContext ctx){
            Double left  = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (ctx.op.getType() == ExprParser.MUL) return left * right;
            return left / right;
        }
        @Override
        public Double visitAddSubMod(ExprParser.AddSubModContext ctx){
            Double left  = visit(ctx.expr(0));
            Double right = visit(ctx.expr(1));
            if (ctx.op.getType() == ExprParser.ADD){
                return left + right;
            } else if (ctx.op.getType() == ExprParser.SUB) return left - right;
            return left % right;
        }
        @Override
        public Double visitParens(ExprParser.ParensContext ctx){
            return visit(ctx.expr());
        }
    }