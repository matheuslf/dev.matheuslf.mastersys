INSERT INTO matriculas (aluno_id, data_matricula, dia_vencimento, status)
VALUES (2, CURRENT_DATE - INTERVAL '90 days', 10, 'ATIVA');

INSERT INTO matriculas (aluno_id, data_matricula, dia_vencimento, status)
VALUES (3, CURRENT_DATE - INTERVAL '60 days', 15, 'ATIVA');

INSERT INTO matriculas_modalidades(
   matricula_id,
   modalidade_id,
   plano_id,
   data_inicio
)
SELECT
    m.id,
    mo.id,
    p.id,
    CURRENT_DATE - INTERVAL '90 days'
FROM matriculas m
JOIN modalidades mo ON mo.nome = 'Musculação'
JOIN planos p ON p.modalidade_id = mo.id AND p.nome = 'Mensal'
WHERE m.aluno_id = 2;

INSERT INTO matriculas_modalidades(
    matricula_id,
    modalidade_id,
    graduacao_id,
    plano_id,
    data_inicio
)
SELECT
    m.id,
    mo.id,
    1,
    p.id,
    CURRENT_DATE - INTERVAL '60 days'
FROM matriculas m
    JOIN modalidades mo ON mo.nome = 'Jiu-Jitsu'
    JOIN planos p ON p.modalidade_id = mo.id AND p.nome = 'Mensal'
WHERE m.aluno_id = 3;

INSERT INTO faturas_matriculas(
       matricula_id,
       data_vencimento,
       valor,
       data_pagamento,
       status
)
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '60 days',
    120.00,
    CURRENT_TIMESTAMP - INTERVAL '58 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 2;


INSERT INTO faturas_matriculas(
    matricula_id,
    data_vencimento,
    valor,
    data_pagamento,
    status
)
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '30 days',
    120.00,
    CURRENT_TIMESTAMP - INTERVAL '29 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 2;

INSERT INTO faturas_matriculas(
    matricula_id,
    data_vencimento,
    valor,
    status
)
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '10 days',
    120.00,
    'ABERTA'
FROM matriculas m
WHERE m.aluno_id = 2;


--
INSERT INTO faturas_matriculas(
    matricula_id,
    data_vencimento,
    valor,
    data_pagamento,
    status
)
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '30 days',
    180.00,
    CURRENT_TIMESTAMP - INTERVAL '28 days',
    'PAGA'
FROM matriculas m
WHERE m.aluno_id = 3;

INSERT INTO faturas_matriculas(
    matricula_id,
    data_vencimento,
    valor,
    status
)
SELECT
    m.id,
    CURRENT_DATE - INTERVAL '15 days',
    120.00,
    'ABERTA'
FROM matriculas m
WHERE m.aluno_id = 2;



