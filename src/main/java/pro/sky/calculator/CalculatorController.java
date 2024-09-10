package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
// /calculator

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam Integer num1, @RequestParam Integer num2) {

        var result = calculatorService.plus(num1,num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {

        var result = calculatorService.minus(num1,num2);
        return num1 + "-" + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        var result = calculatorService.divide(num1,num2);
        return num1 + " / " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        var result = calculatorService.multiply(num1,num2);
        return num1 + " * " + num2 + " = " + result;
    }
}