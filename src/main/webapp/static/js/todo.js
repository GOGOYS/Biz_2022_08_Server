document.addEventListener("DOMContentLoaded", () => {
  const todo = document.querySelector("table.box");

  todo?.addEventListener("click", (e) => {

    const target = e.target;

    const tr = target?.closest("TR");
    const seq = tr?.dataset.seq;


    if (seq) {
      document.location.href = `${rootPath}/todo/${seq}/update`;
    }
  });
});