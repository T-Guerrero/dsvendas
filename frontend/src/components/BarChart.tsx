import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccess } from "types/sale";
import { BASE_URL } from "utils/requests";
import { round } from "utils/format";

type SeriesData = {
  name: string;
  data: number[];
};

type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
};

const fetchDonutChartData = (setChartData: Function) => {
  axios.get(`${BASE_URL}/sales/success-by-seller`).then((response) => {
    const data = response.data as SaleSuccess[];
    let categories: string[] = [];
    let values: number[] = [];
    data.forEach((el) => {
      categories.push(el.sellerName);
      values.push(round((100 * el.deals) / el.visited, 1));
    });

    const newChartData = {
      labels: { categories },
      series: [{ name: "% Sucesso", data: values }],
    };
    setChartData(newChartData);
  });
};

const BarChart = () => {
  const [ChartData, setChartData] = useState<ChartData>({
    labels: {
      categories: [],
    },
    series: [],
  });

  useEffect(() => {
    fetchDonutChartData(setChartData);
  }, []);

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: ChartData.labels }}
      series={ChartData.series}
      type="bar"
      height="240"
    />
  );
};

export default BarChart;
