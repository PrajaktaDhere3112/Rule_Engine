async function createRule() {
    const ruleInput = document.getElementById('ruleInput').value;
    const response = await fetch('/api/rules', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ ruleString: ruleInput })
    });
    const result = await response.json();
    console.log('Created Rule:', result);
}

async function evaluateRule() {
    const dataInput = document.getElementById('dataInput').value;
    const response = await fetch('/api/rules/evaluate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(JSON.parse(dataInput))
    });
    const result = await response.json();
    console.log('Evaluation Result:', result);
}

async function combineRules() {
    const rulesInput = document.getElementById('rulesInput').value;
    const response = await fetch('/api/rules/combine', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(JSON.parse(rulesInput))
    });
    const result = await response.json();
    console.log('Combined AST:', result);
}
