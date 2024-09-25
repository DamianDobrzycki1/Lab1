package ie.atu.week2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class RequestController {
    @GetMapping("/sayHello")
    public String sayHello()
    {
        return "Hi there";
    }

    @GetMapping("/greet/{name}")
    public String greetByName(@PathVariable String name)
    {
        return "Hi there: " +name;
    }
    @GetMapping("/details")
    public String details(@RequestParam String name, @RequestParam int age)
    {
        return "Your name is:" + name + " and your age is: " + age + " Years old, old";

    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int num1, @RequestParam int num2, @RequestParam String operation)
    {
        float ans;
        switch (operation) {
            case "add":
                ans = num1 + num2;
                break;
            case "divide":
                if(num2==0)
                {
                    return "You can't divide by 0";
                }
                else
                {
                    ans = num1/num2;
                }
                break;
            case "subtract":
                ans = (num1-num2);
                break;
            case "multiply":
                ans = num1*num2;
                break;
            default:
                return "You're in the default section";

        }
        return "The correct answer is: " + Float.toString(ans);
    }

}
