class Calculator 
{
    constructor(previousOperandButtonArg, currentOperandButtonArg) 
    {
        this.currentOperandButton   = previousOperandButtonArg;
        this.previousOperandButton  = currentOperandButtonArg;
        this.clear();
    }

    clear() 
    {
        this.currentOperand     = '';
        this.previousOperand    = '';
        this.operation          = undefined;
    }

    updateScreen() 
    {
        this.currentOperandButton.innerText     = this.previousOperand;
        this.previousOperandButton.innerText    = this.currentOperand;
    }

    appendNumber(userInputNumber) 
    {
        if (this.currentOperand.toString().length === maxOperandLenght)     
            return;
        if (userInputNumber === '.' && this.currentOperand.includes('.'))   
            return;

        this.currentOperand = this.currentOperand.toString() + userInputNumber.toString();
    }

    chooseOperation(userInputOperand) 
    {
        //return if we dont have a current operand
        if (this.currentOperand === '') return

        // do the maths with the values stored previously
        // so that it display computed values if another operand is entred
        if (this.previousOperand !== '') 
            this.compute()
        
        this.operation          = userInputOperand;
        this.previousOperand    = this.currentOperand;
        this.currentOperand     = '';
    }

    
    delete() 
    {
        let str = this.currentOperand().toString();
        this.currentOperand = str.substring(0, str.length - 2);
    }

    compute() 
    {
        let result;
        const prev      = parseFloat(this.previousOperand);
        const current   = parseFloat(this.currentOperand);

        if (isNaN(prev) || isNaN(current)) return;

        switch (this.operation) {
            case '+': result = prev + current;  break;
            case '-': result = prev - current;  break;
            case '*': result = prev * current;  break;
            case '÷': result = prev / current;  break;     
            default:                            return;   
        }

        this.currentOperand = result;
        this.operation = undefined;
        this.previousOperand = '';
    }
};


const numberButtons         = document.querySelectorAll('[data-number]')
const operationButtons      = document.querySelectorAll('[data-operation]')
const equalsButton          = document.querySelector('[data-equals]')
const allClearButton        = document.querySelector('[data-all-clear]')
const deleteButton          = document.querySelector('[data-delete]')
const previousOperandButton = document.querySelector('[data-previous-operand]')
const currentOperandButton  = document.querySelector('[data-current-operand]')

const maxOperandLenght      = 10
const myCalculator          = new Calculator(previousOperandButton, currentOperandButton);


numberButtons.forEach(button => {
    button.addEventListener('click', () => {
        myCalculator.appendNumber(button.innerText);
        myCalculator.updateScreen();
        
    })
});

operationButtons.forEach(button => {
    button.addEventListener('click', () => {
        myCalculator.chooseOperation(button.innerText);
        myCalculator.updateScreen();
    })
});

equalsButton.addEventListener('click', button => {
    myCalculator.compute();
    myCalculator.updateScreen();
});

allClearButton.addEventListener('click', button => {
    myCalculator.clear();
    myCalculator.updateScreen();
});

deleteButton.addEventListener('click', button => {
    myCalculator.delete();
    myCalculator.updateScreen();
});