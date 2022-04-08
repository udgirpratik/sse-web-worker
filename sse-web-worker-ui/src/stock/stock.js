import styled from 'styled-components'

const Stock = ( {vastocklue}) => {
    return (
    <Fields>
       <Field> <Label>Stock Name</Label>:<Value>{vastocklue.name} </Value></Field>
       <Field> <Label>Stock Price</Label>:<Value>{vastocklue.price} </Value></Field>
       <Field> <Label>Stock Volume</Label>:<Value>{vastocklue.volume}</Value></Field>
    </Fields>
);


}

const Field = styled.div`
    display: flex;
    flex-direction: row;
    width:600px;
`;

const Value = styled.div`
    margin-left:10px;
`;

const Fields = styled.div`
    background : #FFF;
    padding: 5px;
    color: #000;
    width: 600px;
    border:solid black 2px;
    display: flex;
    flex-direction: column;
    font-size: 18px;
`;

const Label = styled.div`
    flex-direction: row;
    background : #FFF;
    width: 200px;
    text-align:left;
`;

export {Stock};
