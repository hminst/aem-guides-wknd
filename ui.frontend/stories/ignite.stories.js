import { document, console } from "global";
import "../src/main/webpack/site/main.scss";
import "../.storybook/story-styles.css";


export default {
  title: "Ignite",
};

export const Default = () => new Ignite("cmp-ignite--default").markup;
export const Dark = () => new Ignite("cmp-ignite--dark").markup;
export const Yellow = () => new Ignite("cmp-ignite--yellow").markup;
class Ignite {
  constructor(styleClass) {
    this.styleClass = styleClass;
  }

  get markup() {
    return `<div class="${this.styleClass}">
       
                    This is a TEST
      
          <div>`;
  }
}
