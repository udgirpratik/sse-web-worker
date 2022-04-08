import { Stock } from "./stock";
import React, { useEffect } from 'react';

const StockList = (props) => {
    const stockStore = props.stockStore;
    console.log(stockStore)
    useEffect(() => {
        console.log('updated')
       }, [stockStore]);

    let stocks = [];
    props.stockStore.forEach((key, value) => {
        stocks.push(<Stock key={key.id} stock={value} vastocklue={key}/>);
    });
    return <>{stocks}</>
}

export {StockList};