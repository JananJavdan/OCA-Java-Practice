package test_example;

public class TestExample {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        if ((i == ++j) | (i++ == j)) {
            i += j;
        }
        System.out.println(i);
    }
}
// answer: 5
/*
This question is based on 2 concepts:

1. i == ++j is not same as i == j++;
In the case of i == ++j, j is first incremented and then compared with i. While in the case of i == j++;, j is first compared with i and then incremented.

2. The | operator, when applied for boolean operands, ensures that both the sides are evaluated. This is opposed to || which does not evaluate the Right Hand Side if the result can be known by just evaluating the Left Hand Side.

Now, let us see the values of i and j at each step:

int i = 1;
int j = i++; // j is assigned 1 and i is incremented to 2
if( (i==++j) | (i++ == j) )
/* increment j (so, j becomes 2) and compare with i, this means, it returns true.
since we are using the | operator here, we need to evaluate the next condition:
that is, compare i with 2 and increment i. This means i becomes 3.
{
i+=j; //i = 3+2 = 5
}
        System.out.println(i); //prints 5

 */
