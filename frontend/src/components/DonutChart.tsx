import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

type ChartData = {
  labels: string[];
  series: number[];
};

const fetchDonutChartData = (setChartData: Function) => {
  axios.get(`${BASE_URL}/sales/amount-by-seller`).then((response) => {
    const data = response.data as SaleSum[];
    let labels: string[] = [];
    let series: number[] = [];
    data.forEach((el) => {
      labels.push(el.sellerName);
      series.push(el.sum);
    });

    const newChartData = { labels, series };
    setChartData(newChartData);
  });
};

const DonutChart = () => {
  const [ChartData, setChartData] = useState<ChartData>({
    labels: [],
    series: [],
  });

  useEffect(() => {
    fetchDonutChartData(setChartData);
  }, []);

  const options = {
    legend: {
      show: true,
    },
  };

  return (
    <Chart
      options={{ ...options, labels: ChartData.labels }}
      series={ChartData.series}
      type="donut"
      height="240"
    />
  );
};

export default DonutChart;
